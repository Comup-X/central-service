import AnimalGame from './view/AnimalGame.vue'
import Frame from './component/IFrame.vue'
import MarkDown from './view/MarkDown.vue'
import ImageUpload from './view/ImageUpload.vue'

const routes = [
    {name: 'animalGame', path: '/animalGame', component: AnimalGame},
    {name: 'frame', path: '/frame/:url', component: Frame},
    {name: 'markDown', path: '/markDown', component: MarkDown},
    {name: 'imageUpload', path: '/image/upload', component: ImageUpload},
];

export default routes;