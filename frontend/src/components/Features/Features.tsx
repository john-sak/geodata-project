import React from 'react'
import { IFeature } from './IFeatures'
import Feature from './Feature'

const Features = () => {

  const featureSearch: IFeature = {
    title: 'Αναζήτηση',
    subtitle: 'Ανακάλυψε τα δημόσια κτίρια της Ελλάδας στο χάρτη',
    image: 'search.png',
    imageAlt: 'Image of a search icon'
  }

  const featureCompare: IFeature = {
    title: 'Σύγκριση',
    subtitle: 'Δες τις αξιολογήσεις χρηστών στα σημεία ενδιαφέροντός σου',
    image: 'compare.png',
    imageAlt: 'Image of a scale icon'
  }

  const featureMessage: IFeature = {
    title: 'Αξιολόγηση',
    subtitle: 'Μην ξεχνάς να αφήνεις το σχόλιό σου για να συνεισφέρεις και εσύ στο εγχείρημα',
    image: 'message.png',
    imageAlt: 'Image of a message icon'
  }

  return (
    <div className='w-[100%] flex flex-wrap justify-center gap-y-2.5 bg-sky-200'>
        <div className='lg:w-[90%] lg:flex lg:justify-between xl:w-[80%]'>
          <Feature {...featureSearch}/>
          <Feature {...featureCompare}/>
          <Feature {...featureMessage}/>
        </div>
    </div>
  )
}

export default Features