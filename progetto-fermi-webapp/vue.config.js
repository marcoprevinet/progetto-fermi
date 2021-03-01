module.exports = {
  publicPath: process.env.NODE_ENV === 'development' ? '/progetto-fermi' : './',
  outputDir: 'dist',
  pages: {
    index: {
      // entry for the page
      entry: 'src/main.ts'
    }
  },
  devServer: {
    port: 3001,
    proxy: {
      '.*/api': {
        target: 'http://localhost:8080/',
        ws: false,
        changeOrigin: true
      },
    }
  }
}
