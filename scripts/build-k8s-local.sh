cd ../k8s/ || exit

export $(grep -v '^#' .env | xargs)

envsubst < namespace.yaml | kubectl apply -f -

for file in *-datasource.yaml; do
  envsubst < "$file" | kubectl apply -f -
done

for file in *-service.yaml; do
  envsubst < "$file" | kubectl apply -f -
done