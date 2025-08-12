// docker run --rm -i -v ${PWD}:/scripts grafana/k6 run /scripts/grpc_test.js
import grpc from 'k6/net/grpc';
import { check, sleep } from 'k6';

export let options = {
    vus: 100,
    duration: '30s',
};

const client = new grpc.Client();
client.load(['proto'], 'TestService.proto');

export default function () {
    client.connect('host.docker.internal:50051', {
        plaintext: true,
    });

    const response = client.invoke('com.example.grpc.TestService/readAllPurchaseLog', {});

    check(response, {
        'status is OK': (r) => r && r.status === grpc.StatusOK,
    });

    client.close();
    sleep(1);
}
