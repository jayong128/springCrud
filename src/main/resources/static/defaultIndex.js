var main={
    init : function (){
        var _this = this;
        $('#btn-delete').on('click',function (){
             _this.delete();
        })
    },
    delete: function () {
        var id = $('#id').val();
        $.ajax({
            url: "/api/v1/posts/" + id,
            type: "delete",
            dataType: "json",
            contentType:"application/json; charset=utf-8"
        }).done(function (){
            alert('글이 삭제되었습니다.');
            window.location.href = "/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
}
main.init();