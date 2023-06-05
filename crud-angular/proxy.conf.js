const proxy_config = [
  {
    logLevel: 'debug',
    context: ['/api'],
    secure: false,
    target: 'http://localhost:8080',
    pathRewrite: {
      '^/api': ''
    },
    changeOrigin: true,
  }
];

module.exports = proxy_config;
