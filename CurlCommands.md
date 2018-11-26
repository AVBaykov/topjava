Java Enterprise Online Project 
===============================

Список cURL команд для взаимодействия с rest контроллером еды пользователя:

- curl http://localhost:8080/topjava/rest/meals - посмотреть список еды пользователя

- curl --header "Content-Type: application/json" --request POST --data '{Данные в формате JSON}' http://localhost:8080/topjava/rest/meals - добавить прием пищи

- curl http://localhost:8080/topjava/rest/meals/{id} - подставить id нужной еды, для того, чтобы достать конкретный прием пищи

- curl --request DELETE http://localhost:8080/topjava/rest/meals/{id} - удалить еду по id

- curl --header "Content-Type: application/json" --request PUT --data '{Данные в формате JSON}' http://localhost:8080/topjava/rest/meals/{id} - обновить пищу по её id

- curl curl -X GET 'http://localhost:8080/topjava/rest/meals/filter?startDate={Дата в формате ISO}&startTime={Время в формате ISO}&endDate={Дата в формате ISO}&endTime={Время в формате ISO}'