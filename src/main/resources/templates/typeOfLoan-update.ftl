<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h1>Update client</h1>
<div>
    <form name="client" action="" method="POST">
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">ID</label>
            <input class="form-control" type="text" id="exampleInputEmail1" disabled
                   readonly <@spring.formInput "form.id" "" "text"/>

        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Loan</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.loan" "" "text"/>
        </div>

        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Client</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.client" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Amount</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.amount" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">DateOfIssue</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.dateOfIssue" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Description</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.description" "" "text"/>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>