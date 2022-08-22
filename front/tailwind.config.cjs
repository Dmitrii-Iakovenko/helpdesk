/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",    
  ],
  theme: {
    extend: {},
    colors: {
      'completed': '#D9EAD3',
      'grid': '#E2E3E3',
    },    
  },
  plugins: [    
    // require('@tailwindcss/forms'),
  ],
}
