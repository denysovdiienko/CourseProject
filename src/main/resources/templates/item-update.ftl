<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Item</title>
</head>
<body>

<h1>  Creation</h1>

<div>
    <fieldset>
        <legend>Add item</legend>
        <form name="item" action="" method="POST">
            id:<@spring.formInput "form.id" "" "text"/>
            <br>
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.desc" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>


</body>
</html>