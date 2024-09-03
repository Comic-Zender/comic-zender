cd ../k8s/ || exit


for file in *.yaml; do
  envsubst < "$file" | kubectl apply -f -
done

for file in ./**/*.yaml; do
  envsubst < "$file" | kubectl apply -f -
done
