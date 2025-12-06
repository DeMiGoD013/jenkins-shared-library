def call(manifestPath, kubeCredId) {

    withCredentials([file(credentialsId: kubeCredId, variable: 'KCFG')]) {

        sh """
        export KUBECONFIG=${KCFG}

        # Replace image in YAML
        sed "s|REPLACE_IMAGE|${env.IMAGE}|g" ${manifestPath} > /tmp/apply.yaml

        # Apply manifest
        kubectl apply -f /tmp/apply.yaml

        # Extract deployment name automatically
        DEPLOY_NAME=\$(grep -m1 'name:' ${manifestPath} | awk '{print \$2}')

        # Rollout status
        kubectl rollout status deployment/\$DEPLOY_NAME --timeout=120s
        """
    }
}
