# API Documentation

## PetDetailController

This controller handles RESTful requests for pet details.

**Base Path:** `/api/pet-details`

---

### Create Pet Details

*   **POST** `/{petId}`
*   **Description:** Creates a new pet detail entry for a given pet.
*   **Parameters:**
    *   `petId` (path variable): The ID of the pet.
*   **Request Body:**
    *   `PetDetailDto`: A JSON object containing the pet's temperament, weight, and length.
*   **Example Request:**
    ```json
    {
      "temperament": "Friendly",
      "weight": 5.2,
      "length": 30.5
    }
    ```
*   **Response:**
    *   `200 OK`: Returns the created `PetDetail` object.

---

### Get Pet Details

*   **GET** `/{petId}`
*   **Description:** Retrieves the details for a given pet.
*   **Parameters:**
    *   `petId` (path variable): The ID of the pet.
*   **Response:**
    *   `200 OK`: Returns the `PetDetail` object.
    *   `404 Not Found`: If no details are found for the given pet ID.

---

### Update Pet Details

*   **PUT** `/{petId}`
*   **Description:** Updates the details for a given pet.
*   **Parameters:**
    *   `petId` (path variable): The ID of the pet.
*   **Request Body:**
    *   `PetDetailDto`: A JSON object containing the updated temperament, weight, and length.
*   **Example Request:**
    ```json
    {
      "temperament": "Playful",
      "weight": 5.5,
      "length": 31.0
    }
    ```
*   **Response:**
    *   `200 OK`: Returns the updated `PetDetail` object.
    *   `404 Not Found`: If the pet is not found.

---

### Delete Pet Details

*   **DELETE** `/{petId}`
*   **Description:** Deletes the details for a given pet.
*   **Parameters:**
    *   `petId` (path variable): The ID of the pet.
*   **Response:**
    *   `204 No Content`: If the deletion is successful.

## OwnerController

This controller handles web requests for owner information.

---

### Show Owner Creation Form

*   **GET** `/owners/new`
*   **Description:** Displays a form to create a new owner.

---

### Create a New Owner

*   **POST** `/owners/new`
*   **Description:** Processes the submission of the new owner form.
*   **Parameters:**
    *   `owner` (form object): The owner object populated from the form fields.
*   **Response:**
    *   Redirects to the newly created owner's detail page (`/owners/{ownerId}`).

---

### Show Find Owners Form

*   **GET** `/owners/find`
*   **Description:** Displays a form to search for owners.

---

### Find Owners

*   **GET** `/owners`
*   **Description:** Processes the submission of the find owners form.
*   **Parameters:**
    *   `page` (request parameter, optional, default: 1): The page number for pagination.
    *   `owner` (form object): The owner object with the last name to search for.
*   **Response:**
    *   If one owner is found, redirects to the owner's detail page (`/owners/{ownerId}`).
    *   If multiple owners are found, displays a list of owners.
    *   If no owners are found, displays the find owners form again with an error message.

---

### Show Owner Update Form

*   **GET** `/owners/{ownerId}/edit`
*   **Description:** Displays a form to update an existing owner.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner to update.

---

### Update an Owner

*   **POST** `/owners/{ownerId}/edit`
*   **Description:** Processes the submission of the owner update form.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner to update.
    *   `owner` (form object): The owner object with the updated information.
*   **Response:**
    *   Redirects to the updated owner's detail page (`/owners/{ownerId}`).

---

### Show Owner Details

*   **GET** `/owners/{ownerId}`
*   **Description:** Displays the details of a specific owner.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner to display.

## PetController

This controller handles web requests for pet information.

**Base Path:** `/owners/{ownerId}`

---

### Show Pet Creation Form

*   **GET** `/pets/new`
*   **Description:** Displays a form to create a new pet for a specific owner.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner.

---

### Create a New Pet

*   **POST** `/pets/new`
*   **Description:** Processes the submission of the new pet form.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner.
    *   `pet` (form object): The pet object populated from the form fields.
*   **Response:**
    *   Redirects to the owner's detail page (`/owners/{ownerId}`).

---

### Show Pet Update Form

*   **GET** `/pets/{petId}/edit`
*   **Description:** Displays a form to update an existing pet.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner.
    *   `petId` (path variable): The ID of the pet to update.

---

### Update a Pet

*   **POST** `/pets/{petId}/edit`
*   **Description:** Processes the submission of the pet update form.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner.
    *   `petId` (path variable): The ID of the pet to update.
    *   `pet` (form object): The pet object with the updated information.
*   **Response:**
    *   Redirects to the owner's detail page (`/owners/{ownerId}`).

## VisitController

This controller handles web requests for visit information.

**Base Path:** `/owners/{ownerId}/pets/{petId}`

---

### Show Visit Creation Form

*   **GET** `/visits/new`
*   **Description:** Displays a form to create a new visit for a specific pet.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner.
    *   `petId` (path variable): The ID of the pet.

---

### Create a New Visit

*   **POST** `/visits/new`
*   **Description:** Processes the submission of the new visit form.
*   **Parameters:**
    *   `ownerId` (path variable): The ID of the owner.
    *   `petId` (path variable): The ID of the pet.
    *   `visit` (form object): The visit object populated from the form fields.
*   **Response:**
    *   Redirects to the owner's detail page (`/owners/{ownerId}`).

## CrashController

This controller is used to test exception handling.

---

### Trigger an Exception

*   **GET** `/oups`
*   **Description:** Throws a `RuntimeException` to demonstrate exception handling.

## WelcomeController

This controller handles the welcome page.

---

### Show Welcome Page

*   **GET** `/`
*   **Description:** Displays the welcome page.

## VetController

This controller handles web and REST requests for vet information.

---

### Show Vet List (HTML)

*   **GET** `/vets.html`
*   **Description:** Displays a paginated list of veterinarians.
*   **Parameters:**
    *   `page` (request parameter, optional, default: 1): The page number for pagination.

---

### Show Vet List (JSON)

*   **GET** `/vets`
*   **Description:** Returns a list of all veterinarians in JSON format.
*   **Response:**
    *   `200 OK`: Returns a `Vets` object, which contains a list of `Vet` objects.
*   **Example Response:**
    ```json
    {
      "vetList": [
        {
          "id": 1,
          "firstName": "James",
          "lastName": "Carter",
          "specialties": []
        },
        {
          "id": 2,
          "firstName": "Helen",
          "lastName": "Leary",
          "specialties": [
            {
              "id": 1,
              "name": "radiology"
            }
          ]
        }
      ]
    }
    ```
