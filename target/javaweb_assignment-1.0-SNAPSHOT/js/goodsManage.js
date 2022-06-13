$(".form-control").keydown(function (event) {
    if(event.keyCode==13){
        const  temp =document.createElement("form");
        const val = $("#queryById").val();
        temp.action = "GoodsListServlet?model=query&queryById="+val;
        temp.method = "post";
        document.body.appendChild(temp);
        temp.submit();
    }
})

function modify(id,creator,picture,merchant) {
        $("#modify-btn").attr("href","#popup-modify")
        $("#getId").attr("value",id);
        $("#getBelong2").attr("value",creator)
        $("#picture").attr("value",picture)

}

