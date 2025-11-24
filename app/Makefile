run-dist:
	./build/install/app/bin/app

run-json:
	./build/install/app/bin/app -f json src/test/resources/fixtures/value1.json src/test/resources/fixtures/value2.json

run-plain:
	./build/install/app/bin/app -f plain src/test/resources/fixtures/value1.json src/test/resources/fixtures/value2.json

run-stylish:
	./build/install/app/bin/app -f stylish src/test/resources/fixtures/value1.json src/test/resources/fixtures/value2.json

lint:
	./gradlew checkstyleMain

build:
	./gradlew build

.PHONY: build