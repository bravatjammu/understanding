<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
<style>
    div.button {
        float: right;
        margin-left: -50%;
        margin-top: -25px;
        margin-right: 1em;
    }
</style>
        <title>Locale from Browser</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet"/>
        </head>
    <body>
         <div class="container">
            <h1>Chatroom application</h1>
                <form method="GET" action="/registration">
                    <div class="button">
                       <button type="register" class="btn btn-primary">Register</button>
                    </div>
                </form>

                <form method="POST" action="/">

                <div class="form-group">
                    <label for="userName">Username</label>
                    <@spring.formInput "loginModel.userName" "class='form-control'"/>
                    
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <@spring.formPasswordInput "loginModel.password" "class='form-control'"/>
                    <div><@spring.showErrors "<br>" "bg-danger"/></div>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
                
                </form>
            </div>
        </body>
    </html>