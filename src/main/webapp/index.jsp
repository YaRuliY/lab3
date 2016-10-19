<%@page import="db.DataBase" %>
<%@page import="java.util.ArrayList" %>
<%@page import="db.Car" %>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title>Lab3</title>
    <style type="text/css">
        <%@include file="styles/main.css" %>
    </style>
</head>
<body>
<div class="db-div">
    <%
        DataBase dataBase = new DataBase();
        ArrayList<Car> cars = (ArrayList<Car>)dataBase.selectAll();
        int i = 0;
    %>
    <table id="table">
        <thead>
        <tr>
            <td>ID</td>
            <td>Company</td>
            <td>Model</td>
            <td>Price</td>
        </tr>
        </thead>
        <tfoot>
            <c:forEach begin="1" end="<%=cars.size()%>">
                <tr>
                    <td>
                        <%=cars.get(i).getId()%>
                    </td>
                    <td>
                        <%=cars.get(i).getCompany()%>
                    </td>
                    <td>
                        <%=cars.get(i).getModel()%>
                    </td>
                    <td>
                        <%=cars.get(i).getPrice()%>
                    </td>
                    <td>
                        <a href=<%="http://localhost:8080/delete?id="+
                                cars.get(i).getId()+"&company="+
                                cars.get(i).getCompany()+"&model="+
                                cars.get(i).getModel()+"&price="+
                                cars.get(i).getPrice()%>>
                            <button>D</button>
                        </a>
                    </td>
                    <td>
                        <a href=<%="http://localhost:8080/edit.jsp?id="+
                                cars.get(i).getId()+"&company="+
                                cars.get(i).getCompany()+"&model="+
                                cars.get(i).getModel()+"&price="+
                                cars.get(i).getPrice()%>>
                            <button>E</button>
                        </a>
                    </td>
                </tr>
                <%if(i<cars.size()-1) i++;%>
            </c:forEach>
        </tfoot>
    </table>
    <div>
        <form name="create" action="http://localhost:8080/create" method="get">
            <input type="text" placeholder="Company" name="company"><br>
            <input type="text" placeholder="Model" name="model"><br>
            <input type="number" placeholder="Price" name="price"><br>
            <input class="jsp" type="submit" value="Save">
        </form>
    </div>
</div>
</body>
</html>