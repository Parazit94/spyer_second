export MIN_MEMORY=150M
export MAX_MEMORY=1G
export JVM_SERVER_OPTS=-server -Xms${MIN_MEMORY} -Xmx${MAX_MEMORY}
export DEVELOP_SPRING_PROFILE=-Dspring.profiles.active=develop
export DISABLED_WARNING_OPTS=--add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED --add-opens java.desktop/java.awt.font=ALL-UNNAMED --add-opens java.base/java.time=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.lang.invoke=ALL-UNNAMED --add-opens java.base/java.time.zone=ALL-UNNAMED --illegal-access=deny

export SPYER_DEBUG_PORT=7000
export SPYER_OPTS=${DISABLED_WARNING_OPTS} ${JVM_SERVER_OPTS} -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:${SPYER_DEBUG_PORT}

up:
	@echo "Building a project via 'gradlew'"
	@./gradlew clean assemble

	@echo "Starting the Docker containers as a Develop Mode"
	@docker-compose -f docker-compose.yaml up -d --build

down:
	@echo "Stoping and removing created docker containers"
	@docker-compose -f docker-compose.yaml down -v --rmi local

start:
	@echo "Launching existing contatiners"
	@docker-compose -f docker-compose.yaml start

stop:
	@echo "Stoping containers"
	@docker-compose -f docker-compose.yaml stop

re: down up