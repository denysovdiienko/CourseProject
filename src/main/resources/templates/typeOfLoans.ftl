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
<h1>Table of type Of Loans</h1>
<hr>
<a href="/gui/typeOfLoan/create"><input type="button" class="btn btn-success" value="Create" ></a>
<hr>
<div style="width: 70%">
    <table class="table-success table-striped">
        <tr>
            <th>ID</th>
            <th>Loan</th>
            <th>Сlient</th>
            <th>Amount</th>
            <th>DateOfIssue</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <#list typeOfLoans as typeOfLoan>
        <tr>
            <td>${typeOfLoan.id}</td>
            <td>${typeOfLoan.loan}</td>
            <td>${typeOfLoan.client}</td>
            <td>${typeOfLoan.amount}</td>
            <td>${typeOfLoan.dateOfIssue}</td>
            <td>${typeOfLoan.description}</td>
            <td>${typeOfLoan.createdAt}</td>
            <td>${typeOfLoan.updatedAt}</td>
            <td><a href="/gui/typeOfLoan/update/${typeOfLoan.id}"><input type="button" class="btn btn-dark" value="Edit"></a></td>
            <td><a href="/gui/typeOfLoan/delete/${typeOfLoan.id}"><input type="button" class="btn btn-danger" value="Delete"></a></td>
        </tr>
    </#list>
    </table>
</div>
</body>
</html>