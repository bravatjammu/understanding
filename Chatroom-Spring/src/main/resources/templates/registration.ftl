<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
        <title>Locale from Browser</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet"/>
        </head>
    <body>
         <div class="container">
            <h1>Chatroom application</h1>
                <form method="POST">

                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <@spring.formInput "user.firstName" "class='form-control'"/>
                    <div><@spring.showErrors "<br>" "bg-danger"/></div>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <@spring.formInput "user.lastName" "class='form-control'"/>
                     <div><@spring.showErrors "<br>" "bg-danger"/></div>
                </div>
                
                <div class="form-group">
                    <label for="userName">Username</label>
                    <@spring.formInput "user.userName" "class='form-control'"/>
                    <div><@spring.showErrors "<br>" "bg-danger"/></div>
                </div>
                
                <div class="form-group">
                    <label for="emailID">Email ID</label>
                    <@spring.formInput "user.emailID" "class='form-control'"/>
                    <div><@spring.showErrors "<br>" "bg-danger"/></div>
                </div>

                <div class="form-group">    
                    <label for="age">Age</label>  
                    <@spring.formSingleSelect "user.age" ages "class='form-control'"/>     
                    
                </div>

                <div class="form-group">    
                    <label for="gender">Gender</label><br>
                    <@spring.formRadioButtons "user.gender" names "<br>"/>    
                    <div><@spring.showErrors "<br>" "bg-danger"/></div>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <@spring.formPasswordInput "user.password" "class='form-control'"/>
                    <div><@spring.showErrors "<br>" "bg-danger"/></div>
                </div>

                <div class="form-">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
                
                </form>
            </div>
        </body>
    </html>