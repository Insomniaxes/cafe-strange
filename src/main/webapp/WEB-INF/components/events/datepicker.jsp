<!DOCTYPE html>
<html>
<head>
    <title>jQuery DatePicker</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
        });
    </script>

</head>
<body>
<form action="showDate.jsp">
    <label for="datepicker">Datum:</label>
    <input type="text" name="selDate" id="datepicker">
</form>

</body>
</html>