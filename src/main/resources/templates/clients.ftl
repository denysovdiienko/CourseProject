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
<h1>Table of book</h1>
<hr>
<a href="/gui/client/create"><input type="button" class="btn btn-success" value="Create" ></a>
<hr>
<div style="width: 70%">
    <table class="table-success table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>TypeOfProperty</th>
            <th>Address</th>
            <th>PhoneNumber</th>
            <th>ContactPerson</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <#list clients as client>
            <tr>
                <td>${client.id}</td>
                <td>${client.name}</td>
                <td>${client.typeOfProperty}</td>
                <td>${client.address}</td>
                <td>${client.phoneNumber}</td>
                <td>${client.contactPerson}</td>
                <td>${client.description}</td>
                <td>${client.createdAt}</td>
                <td>${client.updatedAt}</td>
                <td><a href="/gui/client/update/${client.id}"><input type="button" class="btn btn-dark" value="Edit"></a></td>
                <td><a href="/gui/client/delete/${client.id}"><input type="button" class="btn btn-danger" value="Delete"></a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>