/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js,jsx}"],
  theme: {
    extend: {
      width: {
        '314': '314px',
        '153': '153px',
        '50':'50px',
        '28':'28px',
      },
      height: {
        '45': '45px',
        '153': '153px',
        '24': '24px',
        '22': '22px',
      },
      borderWidth: {
        '1': '1px',
      },
      borderColor: {
        'cdcdcd': '#cdcdcd',
      },
      boxShadow: {
        'custom-shadow': '2px 2px 5px 2px rgba(152,139,252,0.19)',
        'nav-shadow': '0px 2px 4px 5px rgba(205, 205, 205, 0.1)'
      },
      colors: {
        'keyColor': 'rgba(124, 108, 255, 1)',
        'color2':'rgba(152, 139, 252, 1)',
        'color3':'rgba(188, 178, 252, 1)',
        'color4':'rgba(236, 235, 255, 1)',
        'text2': 'rgba(34, 34, 34, 1)'
      },
    }
  },
  variants: {},
  plugins: [],
}

