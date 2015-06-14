<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Тестовое задание</title>
    </head>
    <body>
        <h2>Тестовое задание "Магазин"</h2>    
        
        <form action="Result" method="POST">
            Количетво касс: <input type="text" name="cashboxes"> <br/>
            Количетво шагов: <input type="text" name="steps"> <br/>
            <input type="submit" name="submit" />
            Процентный состав покупателей. <br/>
            (если оставить пустым, то тип нового покупателя будет выбираться случайным образом)<br/>
            Мужчин (%): <input type="text" name="man"> <br/>
            Женщин (%): <input type="text" name="woman"> <br/>
            Детей  (%): <input type="text" name="child"> <br/>            
        </form>       
        
    </body>
</html>
