import React from 'react'
import { IFeature } from './IFeatures'
import Feature from './Feature'

const Features = () => {

  const featureSearch: IFeature = {
    title: 'Αναζήτηση',
    subtitle: 'Ανακάλυψε τα δημόσια κτίρια της Ελλάδας στον χάρτη',
    image: 'search.png',
    imageAlt: 'Image of a search icon'
  }

  const featureCompare: IFeature = {
    title: 'Αγαπημένα',
    subtitle: 'Δήλωσε σημεία ενδιαφέροντος σε συγκεκριμένη ακτίνα',
    image: 'compare.png',
    imageAlt: 'Image of a scale icon'
  }

  const featureMessage: IFeature = {
    title: 'Ενημερώσεις',
    subtitle: 'Θα ειδοποιηθείς για οποιαδήποτε αλλαγή στα δεδομένα των επιλογών σου',
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