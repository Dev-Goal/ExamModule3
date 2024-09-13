<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Danh sách sách</h1>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <table class="table">
        <thead>
        <tr>
            <th>Số thứ tự</th>
            <th>Mã sách</th>
            <th>Tên sách</th>
            <th>Tác giả</th>
            <th>Số lượng</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sach" items="${sachList}" varStatus="status">
            <tr>
                <th scope="row">${status.count}</th>
                <td>${sach.maSach}</td>
                <td>${sach.tenSach}</td>
                <td>${sach.tacGia}</td>
                <td>${sach.soLuong}</td>
                <td>
                    <c:choose>
                        <c:when test="${sach.soLuong > 0}">
                            <a href="muonsach?maSach=${sach.maSach}" class="btn btn-primary">Mượn sách</a>
                        </c:when>
                        <c:otherwise>
                            <span class="text-danger">Hết sách</span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
