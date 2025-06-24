<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   <div>
    <h1>Spring Boot Electricity Bill</h1>
    <form action="/consumerbill">
        Consumer Id : <input type="text" name="cid"/><p></p>
        Consumer Name: <input type="text" name="cname"><p></p>
        Currect Reading: <input type="text" name="creading"><p></p>
        Previous Reading: <input type="text" name="preading"><p></p>
        <input type="submit" value="PrintBill">
    </form>
    </div>
  </body>
</html>