import React from 'react'
import Head from 'next/head'
import NavBar from './components/NavBar/NavBar'
import { LayoutProps } from './interfaces/ILayout'
import Footer from './components/Footer/Footer'

const Layout = (props: LayoutProps) => {

  const { navbarProps, children } = props;

  return (
    <>
    <Head>
        <title>
            CrowdCritic
        </title>
    </Head>
    <NavBar {...navbarProps}/>
    <main>
        {children}
    </main>
    <Footer/>
    </>
  )
}

export default Layout