cd ../k8s/ || exit

envsubst < namespace.yaml | kubectl apply -f -

for file in *-datasource.yaml; do
  envsubst < "$file" | kubectl apply -f -
done

for file in *-service.yaml; do
  envsubst < "$file" | kubectl apply -f -
done
