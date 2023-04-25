import React from 'react'
import FooterLogo from './FooterLogo'
import FooterLinks from './FooterLinks'
import FooterTeam from './FooterTeam'

const Footer = () => {
  return (
    <footer className='relative h-[170px] w-[100%] bg-sky-700 flex items-center flex-wrap flex-col'>
        <FooterLogo/>
        <FooterLinks/>
        <FooterTeam/>
    </footer>
  )
}

export default Footer