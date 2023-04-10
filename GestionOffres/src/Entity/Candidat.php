<?php

namespace App\Entity;


use App\Repository\CandidatRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;



#[ORM\Entity(repositoryClass: CandidatRepository::class)]
class Candidat
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank(message: "First Name is required")]
    private ?string $FirstName = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank(message: "Last Name is required")]
    private ?string $LastName = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank(message: "Email is required")]
    private ?string $Email = null;

    #[Assert\NotBlank(message: "Description is required")]
    #[ORM\Column(length: 255)]
    private ?string $Description = null;

    #[ORM\ManyToMany(targetEntity: Offre::class, inversedBy: 'candidats')]
    private Collection $offres;

    

    public function __construct()
    {
        $this->offres = new ArrayCollection();
    }



    public function getId(): ?int
    {
        return $this->id;
    }

    public function getFirstName(): ?string
    {
        return $this->FirstName;
    }

    public function setFirstName(string $FirstName): self
    {
        $this->FirstName = $FirstName;

        return $this;
    }

    public function getLastName(): ?string
    {
        return $this->LastName;
    }

    public function setLastName(string $LastName): self
    {
        $this->LastName = $LastName;

        return $this;
    }

    public function getEmail(): ?string
    {
        return $this->Email;
    }

    public function setEmail(string $Email): self
    {
        $this->Email = $Email;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->Description;
    }

    public function setDescription(string $Description): self
    {
        $this->Description = $Description;

        return $this;
    }

    public function __toString(){
        return (string) $this->FirstName;
    }

    /**
     * @return Collection<int, Offre>
     */
    public function getOffres(): Collection
    {
        return $this->offres;
    }

    public function addOffre(Offre $offre): self
    {
        if (!$this->offres->contains($offre)) {
            $this->offres->add($offre);
        }

        return $this;
    }

    public function removeOffre(Offre $offre): self
    {
        $this->offres->removeElement($offre);

        return $this;
    }

    
}
