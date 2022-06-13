<%@ page import="com.example.javaweb_assignment.pojo.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.javaweb_assignment.pojo.Merchant" %><%--
  Created by IntelliJ IDEA.
  User: zhangtianxiang
  Date: 2022/6/9
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script language="JavaScript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="css/googleapis.css">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <style>
        @import url(css/input.css);
        @import url(css/datatable.css);
        @import url(css/goodsManage.css);
    </style>
    <script>
        $(document).ready(function(){
            $('#datatable').DataTable();
        });
    </script>
</head>
<body>
<%! List<Goods> list; int i;
List<Merchant> merchantList; int j;%>
<% list = (List<Goods>) request.getAttribute("goodsList");
    i =0;
    merchantList = (List<Merchant>) request.getAttribute("merchants");
    j = 0;
%>

<script language="JavaScript" type="application/javascript">
    function del(id) {
        if(confirm("确定删除该条记录吗？")){
            location.href = "GoodsListServlet?id=" + id+"&model=delete";
        }
    }
</script>

<script language="JavaScript" type="application/javascript">
    function flash() {
        location.href = "GoodsListServlet?model="+"init";
    }
</script>

<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-4">
                    <h2> <b>商品管理</b></h2>
                </div>
                <div class="col-sm-8">
                    <a href="#" class="btn btn-primary" id = "btn-primary" onclick="flash()"><i class="material-icons">&#xE863;</i> <span>刷新</span></a>
                    <a href="#popup" class="btn btn-add" id = "btn-add"><i class="fa fa-plus fa-lg" aria-hidden="true"></i><span>添加商品</span></a>
                </div>
            </div>
        </div>
        <div class="table-filter">
            <div class="row">
                <div class="col-sm-3">
                </div>
                <div class="col-sm-9">
                    <div class="filter-group">
                        <label>ID</label>
                        <input type="text" class="form-control" name="queryById" id = "queryById">
                    </div>
                    <span class="filter-icon"><i class="fa fa-filter"></i></span>
                </div>
            </div>
        </div>

        <table id="datatable"  class="table table-striped table-hover">
            <thead>

            <tr>
                <th>ID</th>
                <th>商品名称</th>
                <th>价格</th>
                <th>归属于</th>
                <th>信息</th>
                <th>操作</th>
            </tr>
            </thead>
            <% for(;i<list.size();i++) { %>
            <% Goods m = list.get(i); %>
            <tr id = "tr+<%=i%>">
                <td><%=m.getId()%></td>
                <td><a><i class="<%=m.getPicture()%>" aria-hidden="true"></i></a><%=m.getName()%></td>
                <td><%=m.getPrice()%></td>
                <td><%=m.getBelong()%></td>
                <td><%=m.getInfo()%></td>
                <td><a href="#" onclick="del(<%=m.getId()%>)"><i class="fa fa-trash fa-lg" aria-hidden="true"></i></a>
                    <a href="#popup-modify" onclick="modify(<%=m.getId()%>,<%=m.getBelong()%>,<%=m.getPicture()%>,<%=request.getAttribute("belong")%>)" id ="modify-btn"><i class="fa fa-cog fa-lg" aria-hidden="true"></i></a></td>
            </tr>
            <%}%>
            <div class="container">

                <div class="popup" id="popup">
                    <div class="popup-inner">
                        <div class="popup__photo">
                            <img src="image/3edfa4e22a2ac01816d0dfca2334255c.jpeg" alt="">
                        </div>
                        <div class="popup__text">
                            <form id = "Addinfo" action="GoodsListServlet" method="post">
                                <label for="id" class="inp">
                                    <input type="text" id="id" placeholder="" name ="id-input">
                                    <span class="label">ID</span>
                                    <span class="focus-bg"></span>
                                </label>

                                <label for="name" class="inp">
                                    <input type="text" id="name" placeholder="" name = "name-input">
                                    <span class="label">NAME</span>
                                    <span class="focus-bg"></span>
                                </label>

                                <label for="price" class="inp">
                                    <input type="text" id="price" placeholder="" name = "price-input">
                                    <span class="label">PRICE</span>
                                    <span class="focus-bg"></span>
                                </label>

                                <label for="info" class="inp">
                                    <input type="text" id="info" placeholder="" name = "info-input">
                                    <span class="label">INFORMATION</span>
                                    <span class="focus-bg"></span>
                                </label>
                                <input type="text" value="add" name = "model" hidden>
                                <button id = "btn_Login" type="submit">Add</button>

                            </form>

                        </div>
                        <a class="popup__close" href="#">X</a>
                    </div>
                </div>
                <div class="popup" id="popup-modify">
                    <div class="popup-inner">
                        <div class="popup__photo">
                            <img src="image/3edfa4e22a2ac01816d0dfca2334255c.jpeg" alt="">
                        </div>
                        <div class="popup__text">
                            <form id = "Modifyinfo" action="GoodsListServlet" method="post">

                                <label for="name-modify" class="inp">
                                    <input type="text" id="name-modify" placeholder="" name = "name-input">
                                    <span class="label">NAME</span>
                                    <span class="focus-bg"></span>
                                </label>

                                <label for="price-modify" class="inp">
                                    <input type="text" id="price-modify" placeholder="" name = "price-input">
                                    <span class="label">PRICE</span>
                                    <span class="focus-bg"></span>
                                </label>

                                <label for="info-modify" class="inp">
                                    <input type="text" id="info-modify" placeholder="" name = "info-input">
                                    <span class="label">INFORMATION</span>
                                    <span class="focus-bg"></span>
                                </label>

                                <label for="belong-modify" class="inp">
                                    <select id = "belong-modify" name="belong-option">
                                        <%for(;j<merchantList.size();j++){%>
                                        <%Merchant merchant = merchantList.get(j);%>
                                            <option value="<%=merchant.getId()%>"><%=merchant.getName()%></option>
                                        <%}%>
                                    </select>
                                    <span class="focus-bg"></span>
                                </label>
                                <input type="text" value="modify" name = "model" hidden>
                                <input type="text"  name = "modifyId" id="getId" hidden>
                                <input type="text"  name = "creator" id="getBelong2" hidden>
                                <input type="text"  name = "picture" id="picture" hidden>
                                <button id = "btn_Modify" type="submit">Modify</button>

                            </form>

                        </div>
                        <a class="popup__close" href="#">X</a>
                    </div>
                </div>
            </div>

        </table>

    </div>
</div>
<script>
    console.log($("#getId").value)
</script>
<script src="js/goodsManage.js"></script>
<script src="js/datatable.js"></script>
</body>
</html>
