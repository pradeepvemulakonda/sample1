const proxyMiddleware = require('http-proxy-middleware');
const fallbackMiddleware = require('connect-history-api-fallback');

module.exports = {
    startPath: '/',
    port: 3000,
    files: [
        '*.{js}',
        '*.{css}'
    ],
    server: {
        baseDir: './dist',
        index: 'index.html',
        middleware: {
            1: proxyMiddleware('/api', {
                target: 'http://localhost:8080',
                changeOrigin: true,
                onError: function (err, req, res) {
                    console.error('Proxy error: ', err);
                    res.writeHead(500, {
                        'Content-Type': 'text/plain'
                    });
                    res.end('Error: Cannot reach server');
                }
            }),
            2: fallbackMiddleware({
                index: '/index.html',
                verbose: true
            })
        }
    },
    browser: 'default',
    notify: false,
    ghostMode: {
        clicks: false,
        scroll: false,
        forms: {
            submit: false,
            inputs: false,
            toggles: false
        }
    }
};
