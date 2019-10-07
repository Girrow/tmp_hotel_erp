module.exports = {
  chainWebpack: config => {
    config.module.rules.delete("eslint");
  },
  configureWebpack:{
    performance: {
      hints: false
    },
    optimization: {
      splitChunks: {
        minSize: 10000,
        maxSize: 250000,
      }
    }
  },
  devServer: {
    proxy: {
      "/": {
        target: "http://localhost:8119/", // this configuration needs to correspond to the Spring Boot backends' application.properties server.port
        ws: false,
        changeOrigin: true
      }
    }
  },
  outputDir: "../src/main/webapp/resources/",
  indexPath: "../WEB-INF/views/index.jsp"
};
