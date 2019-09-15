# hava-jack

[Android repo](https://github.com/Jeaced/javahack)

[Design](https://figma.com/file/ZZ5f0pw1rQ0WbKiLWPAqBP/Design)

Backend - this repo.

<img width="943" alt="Screen Shot 2019-09-15 at 16 23 49" src="https://user-images.githubusercontent.com/7482065/64922220-51175400-d7d5-11e9-81a6-0721162aba7c.png">

## Idea

Интегрировать Райффайзен БАНК с приложением МойНалог для удобства "самозанятых".

### Фичи

1) регистрация в ФНС как "самозанятый"
2) автоматическая отправка отчетов о доходах в ФНС
3) создание и управление чекам
4) холдирование и накопление процентов от дохода для последующей отплаты
5) начисление процентов на накопительный счёт
6) автоматическая оплата налога раз в месяц

## Limitations

Приложение МойНалог имеет закрытый API, который мы не смогли получить во время хакатона. Поэтому наш прототип эмулирует работу с ним.

## How to start

```bash
docker-compose up -d

mvn clean install

java -jar target/hava-jack-0.0.1-SNAPSHOT.jar
```

