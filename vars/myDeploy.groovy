def call(manifestPath, kubeCredId) {
    withCredentials([file(credentialsId: kubeCredId, variable: 'KCFG')]) {

        sh """
        export KUBECONFIG=\$KCFG

        sed 's|REPLACE_IMAGE|${env.IMAGE}|g' ${manifestPath} > /tmp/apply.yaml

        kubectl apply -f /tmp/apply.yaml
        kubectl rollout status deployment/$(grep -m1 'name:' ${manifestPath} | awk '{print $2}') --timeout=120s
        """
    }
}
