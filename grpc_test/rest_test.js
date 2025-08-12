// docker run --rm -i -v ${PWD}:/scripts grafana/k6 run /scripts/rest_test.js
import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    vus: 100,
    duration: '30s',
};

export default function () {
    const url = 'http://host.docker.internal:8080/api/purchase-log';

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };

    const response = http.get(url, params);

    check(response, {
        'status is 200': (r) => r.status === 200,
    });

    sleep(1);
}
