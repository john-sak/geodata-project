import '@/styles/globals.css'
import type { AppProps } from 'next/app'
import Layout from '@/Layout'
import { useState } from 'react';
import { Roboto } from 'next/font/google'

const roboto = Roboto({
  weight: '400',
  subsets: ['latin'],
})

export default function App({ Component, pageProps }: AppProps) {

  const [navbarProps, setNavbarProps] = useState({
    // Define initial props for the Navbar component here
    menuColor: 'black'
  });

  return (
    <main className={roboto.className}>
      <Layout 
      navbarProps={navbarProps}
      >
        <Component 
        {...pageProps} 
        setNavbarProps={setNavbarProps}
        />
      </Layout>
    </main>
  )
}
