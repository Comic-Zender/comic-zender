cd ../k8s/ || exit

export $(grep -v '^#' .env | xargs)

for file in *-datasource.yaml; do
  envsubst < "$file" | kubectl apply -f -
done

for file in *-service.yaml; do
  envsubst < "$file" | kubectl apply -f -
done