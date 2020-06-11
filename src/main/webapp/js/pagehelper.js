/*
 * @desc 使用时，优先载入jquery
 * @author wrt
 * 仅需载入loadpagebtn()、pageload()两个方法
 * loadpagebtn()放在调用方法内的第一行
 * pageload()放在后端数据成功接收后，载入数字页码
 */
/*
 * @method
 * @param obj 页码层对象名称
 * @desc 载入页码按钮
 */
function loadpagebtn(obj){
    var temp="<ul id='prepage' class='pagination'>"+
        "<li><a>首页</a></li>"+
        "<li><a>上一页</a></li></ul>"+
        "<ul id='numpage' class='pagination'></ul>"+
        "<ul id='nextpage' class='pagination'>"+
        "<li><a>下一页</a></li>"+
        "<li><a style='background-color: #f0ad4e;color: #FFFFFF'>尾页</a></li></ul>";
    if($(obj+"").find('ul').length<=0){
        $(obj+"").append(temp);
    }else{
        $(obj+"").empty();
        $(obj+"").append(temp);
    }
}
/*
 * @method
 * @param obj 条数选择层对象名称
 * @param func 被调用方法名称
 * @desc 载入每页数据显示条数
 */
/*function loadsizeopt(obj){
	let temp="<label class='pagination'>显示</label>"+
            "<label class='pagination'>"+
                "<select class='form-control' id='showsize'>"+
                    "<option>5</option><option>10</option>"+
                 "</select></label><label class='pagination'>条记录/页</label>";
	if($(obj+"").find('select').length<=0){
		$(obj+"").append(temp);
	}else{
    	$(obj+"").empty();
    	$(obj+"").append(temp);
    }

}*/
/*
 * @method
 * @param func 被调用方法名称
 * @param data 后端传入数据
 * @param curpage 当前页码
 * @param pageSize 每页条数
 * @desc 数字页码载入
 */
function pageload(func,data,curpage,pageSize){
    each(func,data,curpage,pageSize);
    var pagenumarr=data.data.navigatepageNums;
    var arrlength=pagenumarr.length;
    if(arrlength-curpage>=5){
        pagenumarr.splice(0,curpage-1);
    }else{
        pagenumarr.splice(0,arrlength-5);
    }

    var pagenumtemp="";
    var $numobj=$('#numpage');
    $numobj.empty();
    if(pagenumarr.length>5){
        $.each(pagenumarr,function(i,e){
            pagenumtemp+="<li><a href=javascript:"+func+"("+e+","+pageSize+")>"+e+"</a></li>";
            if(i===4){
                return false;
            }
        });
        $numobj.append(pagenumtemp);
    }else{
        $.each(pagenumarr,function(i,e){
            pagenumtemp+="<li><a href=javascript:"+func+"("+e+","+pageSize+")>"+e+"</a></li>";
        });
        $numobj.append(pagenumtemp);
    }

}
/*
 * @method
 * @param func 被调用方法名称
 * @param data 后端传入数据
 * @param curpage 当前页码
 * @param pageSize 每页条数
 * @desc 固定按钮a标签属性载入
 */
function each(func,data,curpage,pageSize){
    var $prepage=$('#prepage li a');
    var prepage=data.data.prePage;
    $.each($prepage, function(i,e) {
        var $tempobj=$(e);
        if(i===0||prepage===0){
            ahref(func,$tempobj,1,pageSize);
        }else if(i===1&&prepage!==0){
            ahref(func,$tempobj,prepage,pageSize);
        }
    });
    var $nextpage=$('#nextpage li a');
    var nextpage=data.data.nextPage;
    $.each($nextpage, function(i,e) {
        var $tempobj=$(e);
        var tempval=$tempobj.html();
        if(tempval==="尾页"||0===nextpage){
            ahref(func,$tempobj,data.data.pages,pageSize);
        }else if(tempval==="下一页"){
            ahref(func,$tempobj,nextpage,pageSize);
        }
    });
}
/*
 * @method
 * @param func 被调用方法名称
 * @param obj 页码层对象名称
 * @param pagenum 跳转页码
 * @param pageSize 每页条数
 * @desc a标签属性载入(当前页及页码范围)
 */
function ahref(func,obj,pagenum,pagesize){
    return obj.attr("href","javascript:"+func+"("+pagenum+","+pagesize+")");
}
