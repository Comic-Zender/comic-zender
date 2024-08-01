cd ../compose/local || exit
docker compose --env-file .env -f common.yml -f postgres.yml -f comic-service.yml down
docker compose --env-file .env -f common.yml -f postgres.yml -f comic-service.yml up -d