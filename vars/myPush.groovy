def call() {
    echo "Pushing image: ${env.IMAGE}"
    sh "podman push ${env.IMAGE}"
}
