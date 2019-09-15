# hava-jack

[Android repo](https://github.com/Jeaced/javahack)

[Design](https://figma.com/file/ZZ5f0pw1rQ0WbKiLWPAqBP/Design)

Backend - this repo.

## Idea

Интегрировать Райффайзен БАНК с приложением МойНалог для удобства "самозанятых".

## Limitations

Приложение МойНалог имеет закрытый API, который мы не смогли получить во время хакатона. Поэтому наш прототип эмулирует работу с ним.

## How to start

```bash
docker-compose up -d

mvn clean install

java -jar target/hava-jack-0.0.1-SNAPSHOT.jar
```

