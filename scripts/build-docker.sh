cd ../docker || exit
docker compose --env-file .env -f common.yml -f postgres.yml -f comic-service.yml up -d