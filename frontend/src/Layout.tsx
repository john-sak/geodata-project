import React from 'react'
import Head from 'next/head'
import NavBar from './components/NavBar/NavBar'
import { LayoutProps } from './interfaces/ILayout'

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
    </>
  )
}

export default Layout