Java Enterprise Online Project 
===============================

Список cURL команд для взаимодействия с rest контроллером еды пользователя:



- `curl http://localhost:8080/topjava/rest/meals` - посмотреть список еды пользователя

- `curl --header "Content-Type: application/json" --request POST --data '{"dateTime": "2018-11-25T12:00:00","description": "New Food","calories": 1001}' http://localhost:8080/topjava/rest/meals` - добавить прием пищи

- `curl http://localhost:8080/topjava/rest/meals/100002` - подставить id нужной еды, для того, чтобы достать конкретный прием пищи

- `curl --header "Content-Type: application/json" --request PUT --data '{"dateTime": "2015-05-30T10:00:00","description": "Updated Food","calories": 500}' http://localhost:8080/topjava/rest/meals/100002` - обновить пищу по её id

- `curl --request DELETE http://localhost:8080/topjava/rest/meals/100002` - удалить еду по id

- `curl -X GET 'http://localhost:8080/topjava/rest/meals/filter?startDate=2015-05-30&startTime=10:00&endDate=2015-05-30&endTime=23:00'` - вывести за заданный период