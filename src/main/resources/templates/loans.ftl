<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h1>Table of loan</h1>
<hr>
<a href="/gui/loan/create"><input type="button" class="btn btn-success" value="Create" ></a>
<hr>
<div style="width: 70%">
    <table class="table-success table-striped">
        <tr>
            <th>ID</th>
            <th>CodeType</th>
            <th>Amount</th>
            <th>DateOfIssue</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <#list loans as loan>
            <tr>
                <td>${loan.id}</td>
                <td>${loan.codeType}</td>
                <td>${loan.dateOfIssue}</td>
                <td>${loan.description}</td>
                <td>${loan.createdAt}</td>
                <td>${loan.updatedAt}</td>
                <td><a href="/gui/loan/update/${loan.id}"><input type="button" class="btn btn-dark" value="Edit"></a></td>
                <td><a href="/gui/loan/delete/${loan.id}"><input type="button" class="btn btn-danger" value="Delete"></a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>