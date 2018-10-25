/**
 * Created by Administrator on 2018/10/20 0020.
 */
//
// document.write('<link href="https://cdn.bootcss.com/bootstrap3-dialog/1.35.4/css/bootstrap-dialog.min.css" rel="stylesheet">');
// document.write('<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">')
// document.write('<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css" rel="stylesheet">')
// document.write('<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>')
// document.write('<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>')
// document.write('<script src="https://cdn.bootcss.com/bootstrap3-dialog/1.35.4/js/bootstrap-dialog.min.js"></script>')
//

$.dialogTitle=function(title, message,btn) {
    BootstrapDialog.show({
        title: title,
        message:message,
        size: BootstrapDialog.SIZE_WIDE,
        cssClass: "fade",
        buttons: [{
            label: btn,
            icon: 'fa fa-close',
            action: function(dialog) {
                dialog.close();
            }

        }]
    })
};

/**
 *
 * 远程操作弹框
 * @param title 标题
 * @param viewurl 加载的页面
 * @param viewdata 加载页面时提交的数据
 * @param submit 提交按钮
 * @param close  关闭按钮
 * @param fromurl 提交的地址
 * @param fromid 提交from表单的ID
 * @param fn  回调函数
 */
$.dialogView=function (title,viewurl,viewdata,submit,close,fromurl,fromid,fn) {
    BootstrapDialog.show({
        title: title,
        message: function (dialog) {
            var $message = $('<div></div>');
            var pageToLoad = dialog.getData('pageToLoad');
            $message.load(pageToLoad);
            return $message;
        },
        size: BootstrapDialog.SIZE_WIDE,
        cssClass: "fade",
        data: {
            'pageToLoad':viewurl+viewdata
        },

        buttons: [{
            label: submit,
            action: function(dialog) {

                $.ajax({
                    async:false,
                    type:"POST",
                    url:fromurl,
                    data:$("#"+fromid).serialize(),
                    success:function (res) {

                        fn(res);
                    }

                });
                dialog.close();

            }
        }, {
            label: close,
            icon: 'fa fa-close',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });
}

$.dialogConfirm=function (title,message,submit,close,fn) {

    BootstrapDialog.show({
        title: title,
        message:message,
        size: BootstrapDialog.SIZE_WIDE,
        cssClass: "fade",
        buttons: [{
            label: submit,
            icon: 'fa fa-close',
            action: function(dialog) {
               fn(true);
                dialog.close();
            }},
            {label: close,
            icon: 'fa fa-close',
            action: function(dialog) {
                dialog.close();
            }

        }]
    })

}



jQuery.fn.selectTitle=function (res) {
    var se=$(this);
    $.each(res,function (i,value) {
        var opt=$("<option value=" + value.classId + ">" + value.className + "</option>");
        se.append(opt);
    })

}

    
