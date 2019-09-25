/**
 * Created by majunpeng on 2017/3/30.
 */
(function ($) {
    var sidebar = function (options) {
        this.box           = null;      //DOM元素容器
        this.name          = null;      //zui唯一名称
        this.sidebar       = null;      //组件自身  [deperate]
        this.cache         = true;      //是否进行页面缓存
        this.parent        = null;      //[deperate]
        this.nodes         = [];        //侧边栏节点
        this.urlNodes      = [];
        this.menu          = [];        //侧边栏节点右键菜单
        this.routeData     = {};        //动态数据
        this.selected      = null;      //当前被选中的节点（只读）
        this.icon          = null;      //节点缺省图标
        this.style         = '';        //侧边栏自定义样式
        this.topHTML       = '';        //侧边栏顶部内容
        this.bottomHTML    = '';        //侧边栏底部内容
        this.keyboard      = true;      //是否开启键盘事件
        this.flat          = false;     //是否扁平显示（只读）
        this.hasFocus      = false;
        $.extend(true, this, sysObj.sidebar, options);
    };

    $.fn.sidebar = function(method) {
        if ($.isPlainObject(method)){
            var nodes;
            var object = new sidebar(method);
            if( method.url != null){
                $.ajax({
                    async: false,
                    type:"post",
                    data:null,
                    dataType:"json",
                    url:method.url,
                    success : function(data) {
                        if(data.msg == null){
							object.getNode(data.rows);
							nodes = object.urlNodes;
                        }else{
                            return;
                        }
                    }
                })
            }else{
                nodes = method.nodes
            }
            $.extend(object, { nodes: [] });
            if (nodes != null) {
                object.add(object, nodes);
            }

            if ($(this).length !== 0) {
                object.render($(this)[0]);
            }
            //注册新组件
            sysui[object.name] = object;
            return object;
        }
    };

    sidebar.prototype = {
        node: {
            id              : null,         //唯一ID
            text            : '',           //功能项默认显示文字
            count           : null,         //功能项标签文字
            image           : null,         //功能项图标
            nodes           : [],           //功能项节点
            pageUrl         : '',           //节点的页面地址
            route           : null,         //功能项动态路径
            selected        : false,        //功能项初始是否选中
            expanded        : false,        //功能项初始是否展开
            hidden          : false,        //功能项初始是否隐藏
            disabled        : false,        //功能项初始是否不可用
            collapsible     : true,         //功能项是否可以收缩
            plus            : false,
            // events
            onClick         : null,         //功能项点击回调方法
            onDblClick      : null,         //功能项双击回调方法
            onContextMenu   : null,         //功能项右键菜单项点击回调方法
            onExpand        : null,         //功能项展开回调方法
            onCollapse      : null,         //功能项收缩回调方法
            // 内部使用
            parent          : null,         //功能项的父功能项
            sidebar         : null          //功能项所在的侧边栏
        },

        initNodes:function (data,parent) {
            var obj = this;
            if(arguments.length == 1){
                for(var i = 0 ; i < data.length ; i ++ ){
                    var dt = data[i];
                    if(dt.FPARENT == '' ||  dt.FPARENT == null){
                        var node = {};
                        node.id         = dt.FCODE;
                        node.text       = dt.FNAME;
                        node.pageUrl    = dt.FURL;
                        node.modelCode  = dt.FMODEL;
                        node.modelName  = dt.FNAME;
                        node.startParam = dt.FSTARTPARA;
                        node.startType  = dt.FSTARTTYPe;
                        if(dt.FIMGPATH != null ){
                            if(tsUtils.isUrl(dt.FIMGPATH)){
                                node.image = dt.FIMGPATH;
                                node.icon  = null;
                            }else{
                                node.icon  = dt.FIMGPATH;
                                node.image = null;
                            }
                        }else{
                            node.image = null;
                            node.icon  = null;
                        }
                        if(dt.FISDETAIL == 0){
                            node.nodes = [];
                        }
                        this.urlNodes.push(node);
                    }else{
                        obj.initNodes(dt,dt.FPARENT)
                    }
                }
            }else{
                var node = {};
                node.id         = data.FCODE;
                node.text       = data.FNAME;
                node.pageUrl    = data.FURL;
				node.modelCode  = data.FMODEL;
				node.modelName  = data.FNAME;
				node.startParam = data.FSTARTPARA;
				node.startType  = data.FSTARTTYPe;
				if(data.FIMGPATH != null ){
					if(tsUtils.isUrl(data.FIMGPATH)){
						node.image = data.FIMGPATH;
						node.icon  = null;
					}else{
						node.icon  = data.FIMGPATH;
						node.image = null;
					}
				}else{
					node.image = null;
					node.icon  = null;
				}
                
                obj.insertUrlNodes(this.urlNodes,node,parent);
                
            }
        },
        
        insertUrlNodes:function (nodes,node,parent) {
            for(var i = 0 ; i < nodes.length ; i ++){
                if(nodes[i].id == parent){
                    if( nodes[i].nodes == null){
                        nodes[i].nodes = [];
                    }
                    nodes[i].nodes.push(node);
                }
                if( nodes[i].nodes != null && nodes[i].nodes.length > 0){
                    this.insertUrlNodes(nodes[i].nodes,node,parent);
                }
            }
        },

        getNode:function (data) {
            this.initNodes(data);
        },

        /**
         * 功能项追加节点
         * @param parent 需要添加的节点的id 不填添加到根节点
         * @param nodes  需要添加的节点 array([{},{}])/object({})
         * @returns {*}
         */
        add: function (parent, nodes) {
            if (arguments.length == 1) {
                // need to be in reverse order
                nodes  = arguments[0];
                parent = this;
            }
            if ( parent == null) parent = this.get(parent);
            return this.insert(parent, null, nodes);
        },

        /**
         * 功能项插入节点
         * @param parent 需要添加的节点的id 不填添加到根节点
         * @param before 需要插入的节点id
         * @param nodes 需要添加的节点 array([{},{}])/object({})
         * @returns {*}
         */
        insert: function (parent, before, nodes) {
            var txt, ind, tmp, node, nd;
            if (arguments.length == 2) {
                // need to be in reverse order
                nodes  = arguments[1];
                before = arguments[0];
                if (before != null) {
                    ind = this.get(before);
                    if (ind == null) {
                        if (!$.isArray(nodes)) nodes = [nodes];
                        txt = (nodes[0].caption != null ? nodes[0].caption : nodes[0].text);
                        console.log('ERROR: Cannot insert node "'+ txt +'" because cannot find node "'+ before +'" to insert before.');
                        return null;
                    }
                    parent = this.get(before).parent;
                } else {
                    parent = this;
                }
            }
            if ( parent == null) parent = this.get(parent);
            if (!$.isArray(nodes)) nodes = [nodes];
            for (var o = 0; o < nodes.length; o++) {
                node = nodes[o];
                tmp = $.extend({}, sidebar.prototype.node, node);
                tmp.sidebar = this;
                tmp.parent  = parent;
                nd = tmp.nodes || [];
                tmp.nodes = []; // very important to re-init empty nodes array
                if (before == null) { // append to the end
                    parent.nodes.push(tmp);
                } else {
                    ind = this.get(parent, before, true);
                    if (ind == null) {
                        txt = (node.caption != null ? node.caption : node.text);
                        console.log('ERROR: Cannot insert node "'+ txt +'" because cannot find node "'+ before +'" to insert before.');
                        return null;
                    }
                    parent.nodes.splice(ind, 0, tmp);
                }
                if (nd.length > 0) {
                    this.insert(tmp, null, nd);
                }
            }
            return tmp;
        },

        /**
         * 获取功能项
         * @param parent 需要获取功能项父节点的id
         * @param id 需要获取功能项的id
         * @param returnIndex 是否返回功能项所在位置
         * @returns {*}
         */
        get: function (parent, id, returnIndex) { // 也可以这样调用 get(id)或者 get(id, true)
            if (arguments.length === 0) {
                var all = [];
                var tmp = this.find({});
                for (var t = 0; t < tmp.length; t++) {
                    if (tmp[t].id != null) all.push(tmp[t].id);
                }
                return all;
            } else {
                if (arguments.length == 1 || (arguments.length == 2 && id === true) ) {
                    // need to be in reverse order
                    returnIndex    = id;
                    id            = parent;
                    parent        = this;
                }
                // searches all nested nodes
                if ( parent == null) parent = this.get(parent);
                if (parent.nodes == null) return null;
                for (var i = 0; i < parent.nodes.length; i++) {
                    if (parent.nodes[i].id == id) {
                        if (returnIndex === true) return i; else return parent.nodes[i];
                    } else {
                        var rv = this.get(parent.nodes[i], id, returnIndex);
                        if (rv || rv === 0) return rv;
                    }
                }
                return null;
            }
        },

        /**
         *根据条件查找节点
         * @param parent 需要查找的节点
         * @param params 需要查找的选项
         * @param results 返回的结果集
         * @returns {*}
         */
        find: function (parent, params, results) { // 可以这样使用find({ selected: true })
            if (arguments.length == 1) {
                // need to be in reverse order
                params = parent;
                parent = this;
            }
            if (!results) results = [];
            // searches all nested nodes
            if ( parent == null) parent = this.get(parent);
            if (parent.nodes == null) return results;
            for (var i = 0; i < parent.nodes.length; i++) {
                var match = true;
                for (var prop in params) { // params is an object
                    if (parent.nodes[i][prop] != params[prop]) match = false;
                }
                if (match) results.push(parent.nodes[i]);
                if (parent.nodes[i].nodes.length > 0) results = this.find(parent.nodes[i], params, results);
            }
            return results;
        },
        

        /**
         * 渲染侧边栏
         * @param box DOM素容器
         * @returns {number}
         */
        render: function (box) {
            var obj  = this;
            if (box != null) {
                obj.box = box;
            }
            if (!obj.box) return;

            //基本结构
            $(obj.box)
                .attr('name', obj.name)
                .html('<div id="sidebar-wrap" class="sidebar '+obj.style+'"></div>');

            var node = this.getJQNode();
            $(obj.box).find('#sidebar-wrap').append(node);


            // this.initHtml();

			obj.init();

			obj.initClick();

			var expandNodeId = obj.expand;

			var expandNode = obj.get(expandNodeId);
			while(expandNode.id != 'sidebar'){
				$('#'+expandNode.id).parent('li').find('>ul').attr('aria-expanded','true').addClass('in');
				expandNode = expandNode.parent;
            }
        },

        /**
         * 刷新功能项
         * @param id 需要刷新的功能项id
         * @returns {number}
         */
        initHtml: function () {
            var obj = this;
            var html = '';
            var nd  = this;

            html = obj.getNodeHTML(nd);
            $(obj.box).find('.sidebar').html(html);
        },
        
        select:function (node) {
            var nodes = this.nodes;
            var obj   = this;
            obj.unselect(nodes);
            $('#'+node.id).addClass('selected');
        },
        
        unselect:function (nodes) {
            var obj = this;
            for(var i = 0 ;i < nodes.length ; i++){
                var node = nodes[i];
                $('#'+node.id).removeClass('selected');
                if(node.nodes.length>0)
                    obj.unselect(node.nodes);
            }
        },

        getSelectNode:function () {
            return $('#sidebar-wrap .selected');
		},

        getJQNode:function (node) {
            var obj = this;
            var nodes = null;
            var $node = null;
            var tmp = null;
            var level = null;
            if(arguments.length == 1){
                //层级记录
                tmp   = node.parent;
                level = 0;
                while (tmp) {
                    tmp = tmp.parent;
                    level++;
                }
            }
            if(arguments.length == 0){
                nodes = obj.nodes;
                $node = $('<ul class="level0" id="sidebar-list"></ul>');
                for(var i = 0 ; i < nodes.length ; i++){
                    var $childNode = obj.getJQNode(nodes[i]);
                    $node.append($childNode);
                }
            }else{
                $node = $('<li></li>');
                if(node.nodes != null && node.nodes.length >0 ){
                    var $div = null;
                    if(tsUtils.getExplorer() == 'ie8'){
						$div = $('<div id = "'+node.id+'" class="parent collapse in collapsed" data-toggle="collapse" href="#'+node.id+'-list" aria-expanded="false"></div>');
                    }else{
						$div = $('<div id = "'+node.id+'" class="parent" data-toggle="collapse" href="#'+node.id+'-list" aria-expanded="true"></div>');
                    }
                    var $content = null;
                    if(( node.image == '' || node.image == null) && ( node.icon == '' || node.icon == null)){
                        $content = $('<div class="content" style="text-indent: 16px"></div>');
                        $content.html('&nbsp;'+node.text);
                    }else if(node.image == '' || node.image == null){
                        $content = $('<div class="content"></div>');
                        $content.html('<i class="'+node.icon+'"></i>&nbsp;&nbsp;'+node.text);
                    }else{
                        var $image = $('<div class="icon-image" style="background-image: url(' + tsUtils.getProjectPath() + node.image + ')"></div>');
                        $div.append($image);
                        $content = $('<div class="content"></div>');
                        $content.html(node.text);
                    }
                    $div.append($content);
                    $div.append($('<div class="clear"></div>'));
                    $node.append($div);
                    var $ul = null
                    if(tsUtils.getExplorer() == 'ie8'){
						$ul = $('<ul class="collapse level'+level+'" id="'+node.id+'-list" aria-expanded="false"></ul>');
					}else{
						$ul = $('<ul class="collapse level'+level+'" id="'+node.id+'-list"></ul>');
                    }
                    for(var i = 0 ; i < node.nodes.length ; i++){
                        $ul.append(this.getJQNode(node.nodes[i]));
                    }
                    $node.append($ul);
                }else{
                    var $div = $('<div class="child" id="'+node.id+'"></div>');
                    var $content = null;
                    if(( node.image == '' || node.image == null) && ( node.icon == '' || node.icon == null)){
                        $content = $('<div class="content" style="text-indent: 16px"></div>');
                        $content.html('&nbsp;'+node.text);
                    }else if(node.image == '' || node.image == null){
                        $content = $('<div class="content"></div>');
                        $content.html('<i class="'+node.icon+'"></i>&nbsp;&nbsp;'+node.text);
                    }else{
                        var $image = $('<div class="icon-image" style="background-image: url(' + tsUtils.getProjectPath() + node.image + ')"></div>');
                        $div.append($image);
                        $content = $('<div class="content"></div>');
                        $content.html(node.text);
                    }
                    $div.append($content);
                    $div.append($('<div class="clear"></div>'));
                    $node.append($div);
                }
            }
            return $node;
        },

        
        getNodeHTML:function (nd) {
            var html = '';
            var obj  = this;
            var tmp   = nd.parent;
            var nodes = nd.nodes;
            //层级记录
            var level = 0;
            while (tmp) {
                tmp = tmp.parent;
                level++;
            }

            var divHtml = '';

            if(nd.text != null){
                if(nd.nodes.length>0){
                    if(( nd.image == '' || nd.image == null) && ( nd.icon == '' || nd.icon == null)){
                        divHtml = '<div id="'+nd.id+'" class="parent" data-toggle="collapse" href ="#'+nd.id+'-list">'+'<div class="content" style="text-indent: 16px">&nbsp;'+nd.text+'</div>'+'<div class="clear"></div></div>';
                    }else if( nd.image == '' || nd.image == null){
                        divHtml = '<div id="'+nd.id+'" class="parent" data-toggle="collapse" href ="#'+nd.id+'-list">'+'<div class="content"><i class="'+nd.icon+'"></i>&nbsp;'+nd.text+'</div>'+'<div class="clear"></div></div>';
                    }else{
                        divHtml = '<div id="'+nd.id+'" class="parent" data-toggle="collapse" href ="#'+nd.id+'-list">'+'<div class="icon-image" style="background-image: url(' + tsUtils.getRootPath() + nd.image + ')"></div>'+'<div class="content">'+nd.text+'</div>'+'<div class="clear"></div></div>';
                    }
                }else {
                    if (( nd.image == '' || nd.image == null) && ( nd.icon == '' || nd.icon == null)) {
                        divHtml = '<div id="' + nd.id + '" class="child">' + '<div class="content" style="text-indent: 16px">&nbsp;' + nd.text + '</div>' + '<div class="clear"></div></div>';
                    }else if( nd.image == '' || nd.image == null){
                        divHtml = '<div id="' + nd.id + '" class="child">' + '<div class="content"><i class="' + nd.icon + '"></i>&nbsp;' + nd.text + '</div>' + '<div class="clear"></div></div>';
                    }else{
                        divHtml = '<div id="' + nd.id + '" class="child">' + '<div class="icon-image" style="background-image: url(' + tsUtils.getRootPath() + nd.image + ')"></div>' + '<div class="content">' + nd.text + '</div>' + '<div class="clear"></div></div>';
                    }
                }
            }

            html += divHtml;

            if(nodes.length>0){
                if(level  == 0){
                    html += '<ul class="level'+level+' " id = "'+nd.id+'-list">';
                }else{
                    html += '<ul class="level'+level+' collapse" id = "'+nd.id+'-list">';
                }
            }
            for(var i = 0 ; i < nodes.length ; i ++){
                var child = nodes[i];
                html += '<li>' + obj.getNodeHTML(child) +'</li>'
            }

            if(nodes.length>0){
                html += '</ul>';   
            }

            return html
        },

        /**
         * 初始化sidebar
         */
        init:function (node) {
            var obj  = this;
            if(arguments.length == 0){
                node = obj;
            }
            var tmp   = node.parent;
            var nodes = node.nodes;
            //层级记录
            var level = 0;
            while (tmp) {
                tmp = tmp.parent;
                level++;
            }
            if(nodes.length >0 && arguments.length == 1){
                // $('#'+node.id).collapse('hide');
            }

            if(nodes.length >0){
                for(var i = 0 ;i < nodes.length ; i++){
                    obj.init(nodes[i]);
                }
            }
        },

        initClick:function (node) {
            var obj  = this;
            if(arguments.length == 0){
                node = obj;
            }
            var nodes = node.nodes;
            if( node.onclick != null){
                $('#'+node.id).on('click',function () {
                    obj.select(node);
                    node.onclick();
                })
            }else{
                $('#'+node.id).on('click',function () {
                    obj.select(node);
                    if( node.pageUrl == null) {
                        Hui_admin_tab(node.text);
                    }else{
						sysObj[node.id] = {};
						sysObj[node.id].modelCode = node.modelCode;
						sysObj[node.id].modelName = node.modelName;
						sysObj[node.id].startParam = node.startParam;
						sysObj[node.id].startType = node.startType;
                        Hui_admin_tab(node.text,node.pageUrl,node.id);
                    }
                })
            }
            if(nodes.length >0){
                for(var i = 0 ;i < nodes.length ; i++){
                    obj.initClick(nodes[i]);
                }
            }
        }
    }
})(jQuery);