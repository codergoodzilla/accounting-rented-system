# accounting-rented-system

Приложение представляющее собой REST API сервис для учета аренды транспортных средств.


Состав Docker-контейнеров:

Приложение:
использует и объявляет порт 5000 (http);

PostgreSQL:
использует и объявляет порт 5342 (http);
директории /etc/postgresql, /var/log/postgresql, /var/lib/postgresql объявлены как VOLUME для возможности сохранения БД.
Как собрать и запустить контейнер

Для сборки контейнера нужно выполнить команду вида:

docker build -t accounting-rented-system -f Dockerfile https://github.com/codergoodzilla/accounting-rented-system.git
Или команды:

git clone https://github.com/codergoodzilla/accounting-rented-system.git accounting-rented-system
cd accounting-rented-system/
docker build -t accounting-rented-system -f Dockerfile .
После этого будет создан Docker-образ с именем accounting-rented-system (опция -t).

Запустить ранее собранный контейнер можно командой вида:

docker run -p 5000:5000 --name accounting accounting-rented-system
После этого можно получить доступ к запущенному в контейнере приложению по URL: http://localhost:5000/

Получить список запущенных контейнеров можно командой:

docker ps
Остановить контейнер можно командой:

docker kill hello
