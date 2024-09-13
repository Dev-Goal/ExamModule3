<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mượn sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Mượn sách</h1>
    <form action="muonsach" method="post">
        <input type="hidden" name="maSach" value="${sach.maSach}">
        <div class="form-group">
            <label for="maMuonSach">Mã mượn sách</label>
            <input type="text" class="form-control" id="maMuonSach" name="maMuonSach" pattern="MS-\\d{4}" required>
        </div>
        <div class="form-group">
            <label for="tenSach">Tên sách</label>
            <input type="text" class="form-control" id="tenSach" name="tenSach" value="${sach.tenSach}" readonly>
        </div>
        <div class="form-group">
            <label for="maHocSinh">Tên học sinh</label>
            <select class="form-control" id="maHocSinh" name="maHocSinh">
                <c:forEach var="hocSinh" items="${hocSinhList}">
                    <option value="${hocSinh.tenHocSinh}">${hocSinh.tenHocSinh}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="ngayMuon">Ngày mượn</label>
            <input type="text" class="form-control" id="ngayMuon" name="ngayMuon" value="${ngayMuon}" readonly>
        </div>
        <div class="form-group">
            <label for="ngayTra">Ngày trả</label>
            <input type="date" class="form-control" id="ngayTra" name="ngayTra" required>
        </div>
        <button type="submit" class="btn btn-primary">Mượn sách</button>
        <a href="listsach" class="btn btn-danger">Hủy</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
</body>
</html>
