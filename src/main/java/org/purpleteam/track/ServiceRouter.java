package org.purpleteam.track;

public class ServiceRouter {
//    id, task_name, start_time, end_time, is_active, is_closed
//    Post
///trackings - создание трека
//
//
//    Get
///trackings - получение листа всех треков
///trackings/{Id} - получение треков по id
//
//
//    Delete
///trackings/{id} - удаление трека по id
//
//
//    Put
///trackings/{id} - обновление трека по id
//
//    Patch
///trackings/{id} - обновление отдельных полей объекта

//    Добавление таски
//    POST /?trackings=new&id=1&task_name="New task started"

//    Обновление таски
//    POST /?trackings=put&id=1&task_name="New task started"&status=1

//    Завершение таски
//    POST /?trackings=close&id=1

//    Удаление таски
//    POST /?trackings=delete&id=1&task_name="New task started"

//    Запрос всех тасков
//    GET /?trackings=list

//    Запрос тасков по id
//    GET /?trackings=id&id=1

//    Запрос тасков по cписку id
//    GET /?trackings=teamlid&id=1&id=2&id=3

}
